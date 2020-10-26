package com.example.cleanlogin.ui.main.viewmodel



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtides.dogs.model.LoginRequest
import com.example.cleanlogin.R
import com.example.cleanlogin.data.entities.*
import com.example.cleanlogin.data.entities.LoginFormState
import com.example.cleanlogin.data.repository.UserRepository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch


class LoginViewModel(private val repository: UserRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val disposable = CompositeDisposable()

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult



    fun login(username: String, password: String) {
        viewModelScope.launch {

            val response =  repository.validate(LoginRequest(username,password))

            if(response.mStatus.equals("true",ignoreCase = true)){
                _loginResult.value = LoginResult(success = response.mUser)
            }
            else{
                _loginResult.value = LoginResult(error = R.string.login_failed)
            }
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.isNotBlank()) {
          //  Patterns.EMAIL_ADDRESS.matcher(username).matches()
            return username.length > 5
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}