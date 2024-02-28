package com.example.hotelperemaria.ui.home.ui

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelperemaria.ui.home.data.network.response.RoomsResponse
import com.example.hotelperemaria.ui.home.domain.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase) : ViewModel() {

    // rooms from API
    private val _rooms = MutableLiveData<List<RoomsResponse>>()
    val rooms: LiveData<List<RoomsResponse>> = _rooms

    //Status api request
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    //Error
    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean> = _error

    // Para el mensaje de error
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    // On Init makes the request
    init {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val rooms = homeUseCase()
                //Log.i("xxx", rooms.toString())
                _rooms.postValue(rooms.take(5))
                _isLoading.value = false
            } catch (e: IOException) {
                _isLoading.value = false
                _error.value = true;
                _errorMessage.postValue(e.message.toString())
                Log.i("xDAM Home viewModel", "ERROR: ${e.message.toString()} ${e.cause}")
            }
        }
    }


    //Function that make the animation of resize the topAppBar on scroll in content
    @Composable
    fun calculateTopBarHeight(visibleItemIndex: Int): State<Dp> {
        val initialHeight = 150.dp
        val finalHeight = 50.dp
        val thresholdIndex = 0.2


        return animateDpAsState(
            targetValue = if (visibleItemIndex < thresholdIndex) {
                initialHeight
            } else {
                finalHeight
            },
            animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
            label = "topAppBar animation"
        )
    }
}