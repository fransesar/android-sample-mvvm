package com.example.mvvm.ui.dogslist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.Dogs
import com.example.mvvm.data.MainAPI
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class DogsViewModel @ViewModelInject constructor(
    private val api: MainAPI
//    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val mutableDogs = MutableLiveData<List<Dogs>>()
    val dogs: LiveData<List<Dogs>> = mutableDogs

    fun getDogs() {
        viewModelScope.launch {
            CompositeDisposable().add(
                api.getData()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<List<Dogs>>() {
                        override fun onSuccess(it: List<Dogs>) {
                            mutableDogs.value = it
                        }

                        override fun onError(e: Throwable) {
                            e.printStackTrace()
                        }
                    })
            )
        }

    }
}