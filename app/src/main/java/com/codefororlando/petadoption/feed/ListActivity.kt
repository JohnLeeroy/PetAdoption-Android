package com.codefororlando.petadoption.feed

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.codefororlando.petadoption.PetApplication
import com.codefororlando.petadoption.R
import com.codefororlando.petadoption.about.AboutActivity
import com.codefororlando.petadoption.presenter.list.ListPresenter
import com.codefororlando.petadoption.view.LocationDialogFragment
import nucleus.factory.RequiresPresenter
import nucleus.view.NucleusAppCompatActivity


@RequiresPresenter(ListPresenter::class)
class ListActivity : NucleusAppCompatActivity<ListPresenter>() {

    private lateinit var locationDialog: LocationDialogFragment;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        (application as PetApplication).appComponent()
                .inject(this)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        locationDialog = LocationDialogFragment();

        val petFeedFragment = PetFeedFragment();
        supportFragmentManager.beginTransaction()
                .add(R.id.content, petFeedFragment, "")
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_location, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_search -> {
                Snackbar.make(findViewById(android.R.id.content), "This feature is coming soon", Snackbar.LENGTH_SHORT).show()
                true
            }
            R.id.menu_location -> {
                showLocationDialog()
                true
            }
            R.id.menu_info -> {
                goToAboutPage()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showLocationDialog() {
        if (!locationDialog.isAdded) {
            locationDialog.show(supportFragmentManager, "location_dialog")
        }
    }

    fun goToAboutPage() {
        val aboutPageIntent = Intent(this, AboutActivity::class.java)
        startActivity(aboutPageIntent)
    }

}
