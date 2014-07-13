package com.corneliudascalu.mvpnotes;

import com.corneliudascalu.mvpnotes.data.interactor.InteractorsModule;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * @author Corneliu Dascalu <corneliu.dascalu@osf-global.com>
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
