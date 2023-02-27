package com.example.nokedemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.nokedemo.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var detailsBinding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("user", User::class.java)
        } else {
            intent.getParcelableExtra<User>("user")
        }

        Glide.with(this).load(user?.Picture).into(detailsBinding.profilePic)
        detailsBinding.name.text = user?.Name
        detailsBinding.title.text = user?.Title
        detailsBinding.phone.text = user?.Phone
        detailsBinding.street.text = user?.Street
        detailsBinding.address.text = user?.City + ", " + user?.State + " " + user?.Zipcode
        detailsBinding.email.text = user?.Email
        detailsBinding.birthday.text = user?.Birthday



    }
}