package com.netflix.spinnaker.orca.kato.tasks.quip

import com.netflix.spinnaker.orca.Task
import com.netflix.spinnaker.orca.clouddriver.InstanceService
import retrofit.RestAdapter
import retrofit.client.Client

abstract class AbstractQuipTask implements Task {
  protected abstract Client getRetrofitClient()

  InstanceService createInstanceService(String address) {
    RestAdapter restAdapter = new RestAdapter.Builder()
      .setEndpoint(address)
      .setClient(retrofitClient)
      .build()
    return restAdapter.create(InstanceService.class)
  }
}
