package com.corneliudascalu.mvpnotes.common;

import android.app.Application;
import dagger.ObjectGraph;

/**
 * Defines the structure of the object graph creator. There's no reason to have more than one,
 * but it's useful when testing
 *
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
public interface ObjectGraphCreator {
    ObjectGraph create(Application application);
}
