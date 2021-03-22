package com.lbnkosi.data.model.resource

import com.lbnkosi.data.enums.DTResourceStatus

data class DTResource<out T>(val DTResourceStatus: DTResourceStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): DTResource<T> {
            return DTResource(DTResourceStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String? = "", data: T?): DTResource<T> {
            return DTResource(DTResourceStatus.ERROR, data, msg)
        }

        fun <T> loading(data: T?): DTResource<T> {
            return DTResource(DTResourceStatus.LOADING, data, null)
        }
    }
}
