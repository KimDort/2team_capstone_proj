<template>

    <v-data-table
        :headers="headers"
        :items="dashboard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DashboardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "orderId", value: "orderId" },
                { text: "storeName", value: "storeName" },
                { text: "itemName", value: "itemName" },
                { text: "itemQty", value: "itemQty" },
                { text: "price", value: "price" },
                { text: "status", value: "status" },
                { text: "orderDt", value: "orderDt" },
                { text: "cookedCompDt", value: "cookedCompDt" },
                { text: "deliveryCompDt", value: "deliveryCompDt" },
            ],
            dashboard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/dashboards'))

            temp.data._embedded.dashboards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.dashboard = temp.data._embedded.dashboards;
        },
        methods: {
        }
    }
</script>

