package com.example.model;

import com.example.util.AuctionStatus;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "Auction.findAll", 
                query = "SELECT a FROM Auction a ORDER BY a.endDate ASC, a.currPrice ASC"),
    @NamedQuery(name = "Auction.search", 
                query = "SELECT a FROM Auction a WHERE UPPER(a.item.title) LIKE :search"),
    @NamedQuery(name = "Auction.findBySeller", 
                query = "SELECT a FROM Auction a WHERE a.seller = :seller ORDER BY a.endDate ASC, a.currPrice ASC"),
    @NamedQuery(name = "Auction.findByStatus", 
                query = "SELECT a FROM Auction a WHERE a.status = :status ORDER BY a.endDate ASC, a.currPrice ASC"),
    @NamedQuery(name = "Auction.findByStatusbyCondition", 
                query = "SELECT a FROM Auction a WHERE a.status = :status AND a.item.condition = :condition ORDER BY a.endDate ASC, a.currPrice ASC"),
    @NamedQuery(name = "Auction.findBySellerByStatus", 
                query = "SELECT a FROM Auction a WHERE a.seller = :seller AND a.status = :status ORDER BY a.endDate ASC, a.currPrice ASC"),
    @NamedQuery(name = "Auction.findBySellerByStatusByCondition", 
                query = "SELECT a FROM Auction a WHERE a.seller = :seller AND a.status = :status AND a.item.condition = :condition ORDER BY a.endDate ASC, a.currPrice ASC")
})
public class Auction implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int auctionId;
    @ManyToOne
    @JoinColumn(name = "SELLERID")
    private AuctionUser seller;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "ITEMID")
    private Item item;
    private float currPrice;
    private float increment;
//    private int status;  // 1 = active, 2 = ended, 3 = cancelled
    @Enumerated(EnumType.ORDINAL)  // Stored in the datbase as an int
    private AuctionStatus status = AuctionStatus.ACTIVE;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @OneToMany(mappedBy = "auction")
    private Collection<Bid> bids;
    @ManyToMany
    @JoinTable(name = "WATCHEDAUCTIONS", 
            joinColumns = @JoinColumn(name = "AUCTIONID"), 
            inverseJoinColumns = @JoinColumn(name = "WATCHERID"))
    private Collection<AuctionUser> watchers;

    public Auction() {
    }

    public Auction(int auctionId, AuctionUser seller, Item item, float currPrice, float increment, Date endDate) {
        this.auctionId = auctionId;
        this.seller = seller;
        this.item = item;
        this.currPrice = currPrice;
        this.increment = increment;
        this.endDate = endDate;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public AuctionUser getSeller() {
        return seller;
    }

    public void setSeller(AuctionUser seller) {
        this.seller = seller;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(float currPrice) {
        this.currPrice = currPrice;
    }

    public float getIncrement() {
        return increment;
    }

    public void setIncrement(float increment) {
        this.increment = increment;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }
    
    public void setStatus(int status) {
        this.status = AuctionStatus.values()[status];
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public int getNumBids() {
        return bids.size();
    }

    public void addWatcher(AuctionUser watcher) {
        watchers.add(watcher);
    }

    public void removeWatcher(AuctionUser watcher) {
        watchers.remove(watcher);
    }

    public int getNumWatches() {
        return watchers.size();
    }

    public boolean isWatchedBy(AuctionUser watcher) {
        return watchers.contains(watcher);
    }
}