package com.lbnkosi.domain.model.resource

import com.lbnkosi.domain.enums.ResourceStatus

data class Resource<out T>(val resourceStatus: ResourceStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(ResourceStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(ResourceStatus.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(ResourceStatus.LOADING, data, null)
        }
    }
}
