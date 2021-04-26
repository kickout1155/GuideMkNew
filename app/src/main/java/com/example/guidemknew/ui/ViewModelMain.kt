package com.example.guidemknew.ui

import androidx.lifecycle.*
import com.example.core.domain.Heroes
import com.example.guidemknew.HeroesDb
import com.example.guidemknew.helpers.VersionHelper
import com.example.guidemknew.interactors.Interactors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
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

    private val _listHeroes: MutableStateFlow<MutableList<Heroes>> =
        MutableStateFlow(mutableListOf())
    val listHeroes: StateFlow<MutableList<Heroes>> get() = _listHeroes

    private val _isComplete: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val isComplete: StateFlow<Boolean> get() = _isComplete

    private val _isNeedUpdate: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val isNeedUpdate: StateFlow<Boolean> get() = _isNeedUpdate



    fun click() {
        viewModelScope.launch {
            launch {
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
            }
            launch {
                try {
                    val result = interactors.getHeroes.invoke()
                    _isComplete.value = true
                    _listHeroes.value = result
                } catch (e: Exception) {

                }
            }
        }
    }

    fun updateData() {
        TODO("Not yet implemented")
    }
}