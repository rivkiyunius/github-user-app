package com.qatros.githubuserapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qatros.githubuserapp.utils.BaseSchedulerProvider
import com.qatros.githubuserapp.utils.SchedulerProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author rivki
 * Created 25/03/22 at 16.16
 */
abstract class BaseViewModel: ViewModel() {
    protected val disposable = CompositeDisposable()
    private val _isLoading = MutableLiveData<Boolean>()
    private val _isError = MutableLiveData<String>()
    protected val isLoading: LiveData<Boolean> get() = _isLoading
    protected val isError: LiveData<String> get() = _isError

    protected fun<T> Observable<T>.onResult(action: (T) -> Unit){
        disposable.add(
            this.compose(applyObservablesTransformer())
                .doOnSubscribe { _isLoading.postValue(true) }
                .doOnTerminate { _isLoading.postValue(false) }
                .doOnNext { _isLoading.postValue(false) }
                .doOnError { _isLoading.postValue(false) }
                .subscribe({
                    action(it)
                }, {
                    _isError.postValue(it.localizedMessage)
                })
        )
    }


    private fun<T> applyObservablesTransformer(): ObservableTransformer<T, T> = ObservableTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}