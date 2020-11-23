package com.example.myapplication

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    val repository:MainRepository  = MainRepository()
    val mutableLiveData:MutableLiveData<ArrayList<MainModel>> = MutableLiveData()

    fun getAllLeagues(){

        repository.getServerData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object:SingleObserver<MainModelList>{
                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {

                }

                override fun onSuccess(t: MainModelList) {
                    mutableLiveData.postValue(t.leagues)
                }
            })

    }
}