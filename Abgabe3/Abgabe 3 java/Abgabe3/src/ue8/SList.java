package ue8;

import java.util.Iterator;

/**
 * Schnittstelle zum Zählen von Vorkommen von
 * vergleichbaren Elementen
 * @author barth
 */
public interface SList<T extends Comparable<T>> extends Iterable<T> {

	/**
	 * Hinzufügen eines T.
	 * Falls schon vorhanden wird Anzahl Vorkommen um eins erhöht
	 * Falls noch nicht vorhanden wird Anzahl Vorkommen auf eins gesetzt.
	 * @param t hinzuzufügendes T
	 */
	void add(T t); 
	
	/**
	 * Wie häufig kommt ein T vor.
	 * @param t zu suchendes T
	 * @return Anzahl der Vorkommen von t, 0 wenn nicht vorhanden
	 */
	int count(T t); 
	
	/**
	 * Entfernen aller Vorkommen eines T.
	 * @param t Zu entfernendes T
	 * @return true gdw t kam vorher vor
	 */
	boolean remove(T t); 
	
	/**
	 * Summe der Anzahl der Vorkommen aller T berechnen.
	 * @return Summe der Anzahl der Vorkommen aller T
	 */
	int noOccurences(); 
	
	/**
	 * Anzahl der unterschiedlichen T berechnen.
	 * @return Anzahl der unterschiedlichen T
	 */
	int noWords();
	
	/**
	 * Iterator über alle vorkommenden T zurückgeben
	 * @return
	 */
	Iterator<T> iterator();
	
}
