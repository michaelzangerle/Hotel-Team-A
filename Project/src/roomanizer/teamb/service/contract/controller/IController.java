package roomanizer.teamb.service.contract.controller;

import java.util.Observer;

/**
 * Regelt die Ablauf inerhalb eines Use-Cases
 *
 * @author Johannes
 */
public interface IController {

    /**
     * Bricht den Vorgang ab
     */
    void abort();

    /**
     * Bestätigt den Vorgang und speichert die Daten
     */
    void commit() throws Exception;

    /**
     * Startet den Vorgang
     */
    void start();

    /**
     * Einen "Beobachter" hinzufügen, diese werden verständigt wenn sich
     * Änderungen ergeben
     *
     * @param o Beobachter
     */
    public void addObserver(Observer o);
}
