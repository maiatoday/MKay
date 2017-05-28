package net.maiatoday.mkay

import dagger.Component
import net.maiatoday.mkay.db.DataModule
import net.maiatoday.mkay.db.util.DbCreate
import net.maiatoday.mkay.ui.EntriesViewModel
import javax.inject.Singleton

/**
 * Created by maia on 2017/05/26.
 */
@Component(
        modules = arrayOf(
                AndroidModule::class,
                DataModule::class
        )
)
@Singleton
interface AppComponent {
    fun inject(into: EntriesViewModel)
    fun inject(into: DbCreate)
}

