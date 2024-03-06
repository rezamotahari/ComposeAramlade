package com.parstamin.composearamkade.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parstamin.composearamkade.data.repository.MeditationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class MeditationViewModel(
    private val meditationRepository: MeditationRepository
) : ViewModel() {

    private val _getMeditationCatData =
        MutableStateFlow(MeditationState())
    val getMeditationCat: StateFlow<MeditationState> = _getMeditationCatData.asStateFlow()

    private val _getMeditationData =
        MutableStateFlow(MeditationState())
    val getMeditation: StateFlow<MeditationState> = _getMeditationData.asStateFlow()


    init {
        getMeditationCat()
    }

    fun getMeditationCat() {
        viewModelScope.launch {
            meditationRepository.getMeditationCat()
                .onStart { _getMeditationCatData.update { it.copy(isLoading = true) } }
                .catch { e ->
                    _getMeditationCatData.update { it.copy(message = e.message) }
                }
                .collect { data ->
                    _getMeditationCatData.update { it.copy(allCat = data) }
                }
        }
    }


    fun getMeditationItem(catId: Int) {
        viewModelScope.launch {
            meditationRepository.getMeditationItem(catId)
                .onStart { _getMeditationData.update { it.copy(isLoading = true) } }
                .catch { e ->
                    _getMeditationData.update { it.copy(message = e.message) }
                }
                .collect { data ->

                    _getMeditationData.update { it.copy(allMeditation = data) }

                }
        }
    }

}