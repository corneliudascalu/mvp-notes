package com.corneliudascalu.mvpnotes.common;

import android.app.Application;
import dagger.ObjectGraph;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
 */
public interface ObjectGraphCreator {
    ObjectGraph create(Application application);
}
