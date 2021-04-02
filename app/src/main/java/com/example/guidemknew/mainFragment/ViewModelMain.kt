package com.example.guidemknew.mainFragment

import androidx.lifecycle.*
import com.example.guidemknew.HeroesDb
import com.example.guidemknew.MapperHeroes
import com.example.guidemknew.base.BaseMapper
import com.example.guidemknew.base.SingleLiveEvent
import com.example.guidemknew.database.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ViewModelMain @Inject constructor(
    private val repository: HeroesRepository,
    private val mapper: MapperHeroes
) : ViewModel() {

    private val _listPersons = MutableStateFlow(mutableListOf<HeroesDb>())
    val listPerson: StateFlow<MutableList<HeroesDb>> = _listPersons.asStateFlow()

    private val _message = SingleLiveEvent<String>()
    val message: LiveData<String> get() = _message

    init {

        click()
    }

    fun click() {
        viewModelScope.launch {
            repository.clearDb()
            try {
                val listHeroes = repository.getHeroesNetwork()
                val newList = mapper.listMap(listHeroes)
                newList.forEach {
                    repository.insertHeroes(it)
                }
                val list = repository.getAll()
                _listPersons.value = list
            } catch (e: Exception) {
                _message.value = "Какая то ошибка"
            }
        }
    }

}