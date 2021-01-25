<template>
    <el-row>
        <el-col :span="24">
            <el-card class="box-card">
              <el-col :span="8">
                <el-input
                v-model="requestData.name"
                placeholder="Please input new name."
                clearable>
                </el-input>
              </el-col>
              <el-col :span="8">
                <el-input
                v-model="requestData.symbol"
                placeholder="Please input new symbol."
                clearable>
                </el-input>
              </el-col>
              <el-col :span="8">
                <el-button
                  type="success"
                  @click="addCurrency"
                >追加</el-button>
              </el-col>
            </el-card>
        </el-col>
        <el-col :span="24">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>仮想通貨一覧</span>
            </div>
            <el-table
                :data="currencies"
                style="width: 100%">
              <el-table-column
                  prop="id"
                  label = "通貨ID"
                  width = "200"
              />
              <el-table-column
                  prop="name"
                  label = "通貨名"
                  width = "200"
              />
              <el-table-column
                  prop="symbol"
                  label = "通貨単位"
                  width = "200"
              />
              <el-table-column
                  prop="amount"
                  label = "数量"
                  width = "200"
              />
               <el-table-column
                  prop="operation"
                  label = "Ops"
                  width = "200"
                  align="left"
              >
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="danger"
                  @click="deleteCurrency(scope.row.id)"
                  >
                  x
                </el-button>
              </template>
              </el-table-column>
            </el-table>
          </el-card>
        </el-col>
    </el-row>
</template>

<script>
  import axios from 'axios'
  export default {
    name: "Currency",
    data () {
      return {
        currencies: [],
        requestData: {
          name: null,
          symbol: null,
        }
      }
  },
    created: async function () {
        await this.refresh()
    },
    methods: {
        refresh: async function () {
        const res = await axios.get('http://localhost:8080/vue-test/')
        this.currencies = res.data.currencies
        console.log(this.currencies)
        },
        addCurrency: async function () {
          await axios.post('http://localhost:8080/vue-test/', this.requestData);
          console.log(this.requestData);
          await this.refresh();
        },
        deleteCurrency: async function (id) {
          await axios.delete('http://localhost:8080/vue-test/' + id);
          await this.refresh();
        }
    }
  }
</script>

<style scoped>

</style>
