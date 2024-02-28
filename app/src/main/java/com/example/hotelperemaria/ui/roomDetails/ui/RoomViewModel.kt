package com.example.hotelperemaria.ui.roomDetails.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelperemaria.ui.roomDetails.data.network.response.RoomResponse
import com.example.hotelperemaria.ui.roomDetails.domain.RoomDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(private val detailsUseCase: RoomDetailUseCase): ViewModel() {


    private val _roomType = MutableLiveData("")
    val roomType: LiveData<String> = _roomType

    fun setRoomType(type: String) {
        _roomType.value = type
    }

    // rooms from API
    private val _room = MutableLiveData<RoomResponse>()
    val room: LiveData <RoomResponse> = _room

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    /*init {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val room = detailsUseCase.invoke(roomType)
                Log.i("details", room.toString())
                _room.postValue(room)
            } catch (e: IOException) {
                Log.i("xxxxdetails", e.message.toString())
            }
            _isLoading.value = false
        }
    }*/
    fun loadRoomDetails() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                Log.i("RoomViewModel", "loadRoomDetails called with roomType: ${roomType.value}")
                val room = detailsUseCase.invoke(roomType.value.orEmpty())
                Log.i("details", room.toString())
                _room.postValue(room)
            } catch (e: IOException) {
                Log.i("xxxxdetails", e.message.toString())
            } finally {
                _isLoading.value = false
            }
        }
    }
}
