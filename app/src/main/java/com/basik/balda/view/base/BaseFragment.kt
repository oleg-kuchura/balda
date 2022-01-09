package com.basik.balda.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

open class BaseFragment<B : ViewDataBinding> : Fragment() {

    private var nullablebinding: B? = null
    protected val binding: B
        get() = nullablebinding
            ?: throw IllegalStateException("Binding ${binding.javaClass} not attached to an fragment.")

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
            val method = makeBinding().getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.javaPrimitiveType
            )
            val result = method.invoke(null, inflater, container, false)
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
        return (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<B>
    }

}