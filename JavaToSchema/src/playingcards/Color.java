/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playingcards;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cta
 */
@XmlType(name = "colorType")
@XmlEnum
public enum Color {
    WHITE,
    RED,
    BLACK;
}
