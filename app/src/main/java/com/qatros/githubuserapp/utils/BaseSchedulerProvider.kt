package com.qatros.githubuserapp.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.TestScheduler

/**
 * @author rivki
 * Created 25/03/22 at 16.17
 */
interface BaseSchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
    fun computation(): Scheduler
}

class SchedulerProvider(): BaseSchedulerProvider{
    override fun io(): Scheduler = Schedulers.io()
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
    override fun computation(): Scheduler = Schedulers.computation()
}

class TrampolineSchedulerProvider(): BaseSchedulerProvider{
    override fun io(): Scheduler = Schedulers.trampoline()
    override fun ui(): Scheduler = Schedulers.trampoline()
    override fun computation(): Scheduler = Schedulers.trampoline()
}

class TestSchedulerProvider(private var scheduler: TestScheduler): BaseSchedulerProvider{
    override fun io(): Scheduler = scheduler
    override fun ui(): Scheduler = scheduler
    override fun computation(): Scheduler = scheduler
}

