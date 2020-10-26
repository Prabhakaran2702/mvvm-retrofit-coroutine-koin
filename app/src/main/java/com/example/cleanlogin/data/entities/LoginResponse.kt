package com.example.cleanlogin.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class LoginResponse(

    @SerializedName("message")
     var mMessage: String? = null,
    @SerializedName("object")
     val mUser: User? = null,

    @SerializedName("status")
     val mStatus: String? = null,

    @SerializedName("totalNumberOfRows")
     val totalNumberOfRows: String? = null


)

@Parcelize
@Entity(tableName = "user")
class User(
    @SerializedName("createdUser")
     var mCreatedUser: String? = null,
    @SerializedName("creationDate")
 val mCreationDate: String? = null,

@SerializedName("emailId")
 val mEmailId: String? = null,

    @PrimaryKey
@SerializedName("employeeId")
 val mEmployeeId: String,

@SerializedName("firstName")
 val mFirstName: String? = null,

@SerializedName("lastName")
 val mLastName: String? = null,

@SerializedName("mobileNumber")
 val mMobileNumber: String? = null,

@SerializedName("password")
 val mPassword: String? = null,

@SerializedName("phoneNumber")
 val mPhoneNumber: String? = null,

@SerializedName("status")
 val mStatus: String? = null,

@SerializedName("userName")
 val mUserName: String? = null,

@SerializedName("userType")
 val mUserType: String? = null,

@SerializedName("customerCode")
 val customerCode: String? = null,

@SerializedName("contractNo")
 val contractNo: String? = null,

@SerializedName("trackingFlag")
 var trackingFlag: String? = null) : Parcelable
