
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.ApiClient
import com.example.myapplication.Doctors
import com.example.myapplication.DoctorsAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DoctorsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        ApiClient.instance.getDoctors().enqueue(object : Callback<List<Doctors>> {
            override fun onResponse(
                call: Call<List<Doctors>>,
                response: Response<List<Doctors>>
            ) {
                if (response.isSuccessful) {
                    val doctors = response.body() ?: emptyList()
                    adapter = DoctorsAdapter(doctors)
                    binding.recyclerView.adapter = adapter
                } else {
                    Log.e("API", "Response Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Doctors>>, t: Throwable) {
                Log.e("API", "Connection Failed: ${t.message}")
            }
        })
    }
}