package com.sevtinge.hyperceiler.module.hook.systemui

import com.github.kyuubiran.ezxhelper.*
import com.sevtinge.hyperceiler.module.hook.systemui.statusbar.model.MobileTypeSingle2Hook.findClass
import com.sevtinge.hyperceiler.utils.*

@Suppress("MemberVisibilityCanBePrivate")
object Dependency {
    private const val DEPENDENCY = "com.android.systemui.Dependency"

    @JvmStatic
    @get:JvmName(name = "getDependency")
    val sDependency: Any?
        get() = findClass(DEPENDENCY, EzXHelper.classLoader).getStaticObjectField("sDependency")

    @JvmStatic
    @get:JvmName(name = "getMiuiLegacyDependency")
    val mMiuiLegacyDependency: Any?
        get() = sDependency?.getObjectField("mMiuiLegacyDependency")

    @JvmStatic
    @get:JvmName(name = "getDependencies")
    val mDependencies: Map<*, *>?
        get() = sDependency?.getObjectField("mDependencies") as Map<*, *>?

    @JvmStatic
    fun getDependencyInner(depClz: Class<*>): Any? {
        return sDependency?.callMethod("getDependencyInner", depClz)
    }

    @JvmStatic
    fun getDependencyInner(depClzName: String): Any? {
        return getDependencyInner(findClass(depClzName, EzXHelper.classLoader))
    }
}