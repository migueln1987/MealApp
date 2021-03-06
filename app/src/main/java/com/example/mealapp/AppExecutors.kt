package com.example.mealapp

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors private constructor(private val diskIO: Executor, private val networkIO: Executor, private val mainThread: Executor){

    fun diskIO(): Executor {
        return diskIO
    }

    fun mainThread(): Executor {
        return mainThread
    }

    fun networkIO(): Executor {
        return networkIO
    }

    private class MainThreadExecutor : Executor {
        override fun execute(command: Runnable?) {
            mainThreadHandler.post(command)
        }

        private val mainThreadHandler = Handler(Looper.getMainLooper())
    }

    companion object {
        private val LOCK = Any()
        private var sInstance: AppExecutors? = null

        val instance: AppExecutors
        get() {
            if (sInstance == null) {
                synchronized(LOCK) {
                    sInstance = AppExecutors(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        MainThreadExecutor())
                }
            }
            return instance!!
        }
    }
}