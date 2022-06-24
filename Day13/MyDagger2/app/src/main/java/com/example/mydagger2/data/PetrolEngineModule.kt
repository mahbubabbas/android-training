package com.example.mydagger2.data

import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule {
    @Provides
    fun provider(petrolEngine: PetrolEngine): Engine {
        return petrolEngine
    }
}
