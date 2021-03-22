package com.lbnkosi.domain.model.resource

import com.lbnkosi.domain.enums.DMResourceStatus

data class DMResource<out T>(val resourceStatus: DMResourceStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): DMResource<T> {
            return DMResource(DMResourceStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): DMResource<T> {
            return DMResource(DMResourceStatus.ERROR, data, msg)
        }

        fun <T> loading(data: T?): DMResource<T> {
            return DMResource(DMResourceStatus.LOADING, data, null)
        }
    }
}
