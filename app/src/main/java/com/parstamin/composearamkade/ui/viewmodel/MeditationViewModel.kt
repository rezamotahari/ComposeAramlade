package com.parstamin.composearamkade.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.parstamin.composearamkade.data.model.ResponseMediationItem
import com.parstamin.composearamkade.data.model.ResponseMeditationCatItem
import com.parstamin.composearamkade.data.repository.MeditationRepository
import com.parstamin.composearamkade.utils.MyResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch



class MeditationViewModel(
    private val meditationRepository: MeditationRepository
) : ViewModel() {

    private val _getMeditationCatData =
        MutableStateFlow<MyResponse<List<ResponseMeditationCatItem>>>(MyResponse.loading())
    val getMeditationCat: StateFlow<MyResponse<List<ResponseMeditationCatItem>>> =
        _getMeditationCatData


    private val _getMeditationData =
        MutableStateFlow<MyResponse<List<ResponseMediationItem>>>(MyResponse.loading())
    val getMeditation: StateFlow<MyResponse<List<ResponseMediationItem>>> =
        _getMeditationData


    fun getMeditationCat() {
        viewModelScope.launch {
            meditationRepository.getMeditationCat()
                .onStart { _getMeditationCatData.value = MyResponse.loading() }
                .catch { e ->
                    _getMeditationCatData.value = MyResponse.error(e.message ?: "Unknown error")
                }
                .collect {

                    _getMeditationCatData.value = MyResponse.success(it)

                }
        }
    }


    fun getMeditationItem(catId: Int) {
        viewModelScope.launch {
            meditationRepository.getMeditationItem(catId)
                .onStart { _getMeditationData.value = MyResponse.loading() }
                .catch { e ->
                    _getMeditationData.value = MyResponse.error(e.message ?: "Unknown error")
                }
                .collect {

                    _getMeditationData.value = MyResponse.success(it)

                }
        }
    }

}