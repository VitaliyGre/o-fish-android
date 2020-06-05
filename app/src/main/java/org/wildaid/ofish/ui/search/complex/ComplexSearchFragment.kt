package org.wildaid.ofish.ui.search.complex

import androidx.fragment.app.viewModels
import org.wildaid.ofish.R
import org.wildaid.ofish.ui.search.base.BaseSearchFragment
import org.wildaid.ofish.ui.search.base.BaseSearchType
import org.wildaid.ofish.util.getViewModelFactory

class ComplexSearchFragment : BaseSearchFragment<SearchModel>() {
    override fun createViewModel() =
        viewModels<ComplexSearchViewModel> { getViewModelFactory() }.value

    override fun createAdapter(itemListener: (SearchModel) -> Unit) =
        ComplexSearchAdapter(itemListener)

    override fun getSearchTitle(): String {
        return getString(
            when (currentSearchEntity) {
                is SearchBusiness -> R.string.business
                is SearchViolation -> R.string.violation
                is SearchRecords -> R.string.find_records
                is SearchVessels -> R.string.new_boarding
                is SearchCrew -> R.string.crew
                else -> R.string.empty
            }
        )
    }

    object SearchBusiness : BaseSearchType()
    object SearchRecords : BaseSearchType()
    object SearchVessels : BaseSearchType()
    object SearchViolation : BaseSearchType()
    object SearchCrew : BaseSearchType()
}