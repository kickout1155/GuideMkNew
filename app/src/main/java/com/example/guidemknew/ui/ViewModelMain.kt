package com.example.guidemknew.ui

import androidx.lifecycle.*
import com.example.core.domain.Hero
import com.example.guidemknew.helpers.VersionHelper
import com.example.guidemknew.interactors.Interactors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ViewModelMain @Inject constructor(
    private val interactors: Interactors,
    private val versionHelper: VersionHelper
) : ViewModel() {

    private val _listHero: MutableStateFlow<MutableList<Hero>> =
        MutableStateFlow(mutableListOf())
    val listHero: StateFlow<MutableList<Hero>> get() = _listHero

    private val _isComplete: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val isComplete: StateFlow<Boolean> get() = _isComplete

    private val _isNeedUpdate: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val isNeedUpdate: StateFlow<Boolean> get() = _isNeedUpdate


    fun click() {
        viewModelScope.launch {
                val isCorrect =
                    try {
                        versionHelper.isCorrectVersion()
                    } catch (e: Exception) {
                        false
                    }
                _isNeedUpdate.value = !isCorrect
                if (!isCorrect) {
                    _isComplete.value = true
                }
//            пока закоментим, будем обновлять все данные
//            launch {
//                try {
//                    val result = interactors.getHeroes.invoke()
//                    _isComplete.value = true
//                    _listHeroes.value = result
//                } catch (e: Exception) {
//
//                }
//            }
        }
    }

    fun updateData() {

    }
}