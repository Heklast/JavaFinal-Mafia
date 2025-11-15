/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mafiagame.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * The knowledge you have at any given time, in a arrayList, and the methods related
 * 
 */

public class Knowledge {

    /** 
     * Internal list of secrets, stored in the order they were added.
     */
    private final List<String> infoList = new ArrayList<>();

    /**
     * Creates a new {@code Knowledge} object containing an initial piece of information.
     *
     * @param info the initial secret to store; ignored if {@code null} or blank
     */
    public Knowledge(String info) {
        addInfo(info);
    }

    /**
     * Adds a new piece of information to the knowledge list.
     *
     * <p>Null or blank strings are ignored. Leading and trailing spaces
     * are removed before storage.</p>
     *
     * @param info the information to add
     */
    public void addInfo(String info) {
        if (info == null) {
            return;
        }
        String trimmed = info.trim();
        if (!trimmed.isEmpty()) {
            infoList.add(trimmed);
        }
    }

    /**
     * Returns a copy of all stored secrets.
     *
     * <p>The returned list is a <strong>defensive copy</strong>, meaning
     * callers may modify it freely without affecting the internal data.</p>
     *
     * @return a new list containing all stored secrets
     */
    public List<String> getInfo() {
        return new ArrayList<>(infoList);
    }

    /**
     * Returns the first stored secret without removing it.
     *
     * @return the first secret, or {@code null} if none exist
     */
    public String getFirstInfo() {
        return infoList.isEmpty() ? null : infoList.get(0);
    }

    /**
     * Removes the first secret from the list, if one exists.
     */
    public void removeFirstInfo() {
        if (!infoList.isEmpty()) {
            infoList.remove(0);
        }
    }

    /**
     * Returns the number of secrets stored.
     *
     * @return the size of the internal list
     */
    public int size() {
        return infoList.size();
    }

    /**
     * Determines whether any secrets are stored.
     *
     * @return {@code true} if at least one secret exists; {@code false} otherwise
     */
    public boolean hasSecrets() {
        return !infoList.isEmpty();
    }

    /**
     * Reveals (and removes) the first stored secret.
     *
     * <p>This method is destructive: calling it consumes the secret,
     * meaning it will no longer be stored afterwards.</p>
     *
     * @return the removed secret, or {@code null} if no secrets are available
     */
    public String revealFirstSecret() {
        if (infoList.isEmpty()) {
            return null;
        }
        return infoList.remove(0);
    }
}