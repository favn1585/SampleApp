package com.codingchallenge.extensions

import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

val <T : Fragment> KClass<T>.TAG get() = java.canonicalName