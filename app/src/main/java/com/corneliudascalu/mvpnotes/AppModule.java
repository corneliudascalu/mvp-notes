package com.corneliudascalu.mvpnotes;

import com.corneliudascalu.mvpnotes.data.interactor.InteractorsModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@gmail.com>
 */
@Module(injects = {MVPNotesApp.class},
        includes = {InteractorsModule.class}
)
public class AppModule {
    private MVPNotesApp app;

    public AppModule(MVPNotesApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public MVPNotesApp provideApplication() {
        return app;
    }
}
