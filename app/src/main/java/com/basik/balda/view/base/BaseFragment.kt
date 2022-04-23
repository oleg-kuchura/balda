package com.basik.balda.view.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.basik.balda.BaldaApp
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

open class BaseFragment<B : ViewDataBinding> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var nullablebinding: B? = null
    protected val binding: B
        get() = nullablebinding
            ?: throw IllegalStateException("Binding ${binding.javaClass} not attached to an fragment.")

    override fun onAttach(context: Context) {
        @Suppress("UNCHECKED_CAST")
        BaldaApp.instance?.appComponent?.inject(this as BaseFragment<ViewDataBinding>)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        nullablebinding = null
    }

    private fun setupBinding(inflater: LayoutInflater, container: ViewGroup?) {
        try {
            val inflateMethod = makeBinding().getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.javaPrimitiveType
            )
            val result = inflateMethod.invoke(null, inflater, container, false)
            @Suppress("UNCHECKED_CAST")
            nullablebinding = result as B
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
    }

    private fun makeBinding(): Class<B> {
        @Suppress("UNCHECKED_CAST")
        return getGenericSuperclass().actualTypeArguments[0] as Class<B>
    }

    private fun getGenericSuperclass(): ParameterizedType {
        return javaClass.genericSuperclass as ParameterizedType
    }

}