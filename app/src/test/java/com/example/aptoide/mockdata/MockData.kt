package com.example.aptoide.mockdata

import com.example.aptoide.model.All
import com.example.aptoide.model.AppInfo
import com.example.aptoide.model.AppsDataset
import com.example.aptoide.model.Data
import com.example.aptoide.model.Datasets
import com.example.aptoide.model.ListApps
import com.example.aptoide.model.Responses

val appsDatasetMockData = AppsDataset(
    responses = Responses(
        listApps = ListApps(
            datasets = Datasets(
                all = All(
                    data = Data(
                        appInfo = arrayListOf<AppInfo>(
                            AppInfo(
                                id = 1,
                                name = "First App",
                                packageName = "a.b.c",
                                rating = 2.4f
                            ),
                            AppInfo(
                                id = 2,
                                name = "Second App",
                                packageName = "a.b.d",
                                rating = 3.4f
                            )
                        )
                    )
                )
            )
        )
    )
)