<template>
  <div>
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="7">
          <el-input placeholder="请输入药品名称" v-model="addForm.drugsName" clearable @clear="doQuery()">
            <el-button slot="append" icon="el-icon-search" @click="doQuery()">
            </el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="addDialogVisable = true">添加药品信息</el-button>
        </el-col>
      </el-row>


      <el-table :data="drugsList">
        <el-table-column label="id" prop="id"></el-table-column>
        <el-table-column label="药品编码" prop="drugsCode"></el-table-column>
        <el-table-column label="药品名称" prop="drugsName"></el-table-column>
        <el-table-column label="规格" prop="drugsFormat"></el-table-column>
        <el-table-column type="包装单位" prop="drugsUnit"></el-table-column>
        <el-table-column label="药品剂型" prop="drugsDosageID"></el-table-column>
        <el-table-column label="药品类型" prop="drugsTypeID"></el-table-column>
        <el-table-column label="拼音助记码" prop="mnemonicCode"></el-table-column>
        <el-table-column label="单价" prop="drugsPrice"></el-table-column>
        <el-table-column label="厂家" prop="manufacturer"></el-table-column>
        <el-table-column label="创建日期" prop="creationDate"></el-table-column>
        <el-table-column label="最后修改时间" prop="lastUpdateDate"></el-table-column>
        <el-table-column label="删除标记" prop="delMark"></el-table-column>

        <el-table-column label="操作" style="width: 200px;">
          <template slot-scope="scope">
            <div style="text-align: center;"><el-button size="mini" type="text" icon="el-icon-edit"
                @click="enableUpdateDialog(scope.row)">修改</el-button></div>
            <div style="text-align: center;"><el-button size="mini" type="text" icon="el-icon-delete"
                @click="doDelete(scope.row)" v-hasPermi="['doctor:doctor:remove']">删除</el-button></div>

          </template>
        </el-table-column>

        <!-- <el-table-column label="修改操作" width="100px">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" @click="enableUpdateDialog(scope.row)">修改</el-button>
          </template>
        </el-table-column>

        <el-table-column label="删除操作" width="100px">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" @click="doDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column> -->
      </el-table>
    </el-card>
    <!--添加药品信息-->
    <el-dialog title="添加药品信息" :visible.sync="addDialogVisable" width="50%" @close="addDialogClosed">
      <el-form :model="addForm" ref="addFormRed" label-width="100px">
        <el-form-item required label="药品编码" prop="drugsCode">
          <el-input v-model="addForm.drugsCode"></el-input>
        </el-form-item>

        <el-form-item required label="药品名称" prop="drugsName">
          <el-input v-model="addForm.drugsName"></el-input>
        </el-form-item>

        <el-form-item required label="规格" prop="drugsFormat">
          <el-input v-model="addForm.drugsFormat"></el-input>
        </el-form-item>

        <el-form-item required label="包装单位" prop="drugsUnit">
          <el-input v-model="addForm.drugsUnit"></el-input>
        </el-form-item>

        <el-form-item required label="药品剂型" prop="drugsDosageID">
          <el-input v-model="addForm.drugsDosageID"></el-input>
        </el-form-item>

        <el-form-item required label="药品类型" prop="drugsTypeID">
          <el-input v-model="addForm.drugsTypeID"></el-input>
        </el-form-item>

        <el-form-item required label="拼音助记码" prop="mnemonicCode">
          <el-input v-model="addForm.mnemonicCode"></el-input>
        </el-form-item>

        <el-form-item required label="单价" prop="drugsPrice">
          <el-input v-model="addForm.drugsPrice"></el-input>
        </el-form-item>

        <el-form-item required label="厂家" prop="manufacturer">
          <el-input v-model="addForm.manufacturer"></el-input>
        </el-form-item>

        <el-form-item label="创建日期" prop="creationDate">
          <el-input v-model="addForm.creationDate"></el-input>
        </el-form-item>

      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addDialogVisable = false">取 消</el-button>
        <el-button type="primary" @click="doAdd()">确 定</el-button>
      </span>
    </el-dialog>

    <!--修改用户-->
    <el-dialog title="修改用户" :visible.sync="updateDialogVisable" width="50%" @close="updateDialogClosed">
      <el-form :model="currentRow" ref="addFormRed" label-width="100px">

        <el-form-item label="药品编码" prop="drugsCode">
          <el-input v-model="currentRow.drugsCode"></el-input>
        </el-form-item>

        <el-form-item label="药品名称" prop="drugsName">
          <el-input v-model="currentRow.drugsName"></el-input>
        </el-form-item>

        <el-form-item label="规格" prop="drugsFormat">
          <el-input v-model="currentRow.drugsFormat"></el-input>
        </el-form-item>

        <el-form-item label="包装单位" prop="drugsUnit">
          <el-input v-model="currentRow.drugsUnit"></el-input>
        </el-form-item>

        <el-form-item label="药品剂型" prop="drugsDosageID">
          <el-input v-model="currentRow.drugsDosageID"></el-input>
        </el-form-item>

        <el-form-item label="药品类型" prop="drugsTypeID">
          <el-input v-model="currentRow.drugsTypeID"></el-input>
        </el-form-item>

        <el-form-item label="拼音助记码" prop="mnemonicCode">
          <el-input v-model="currentRow.mnemonicCode"></el-input>
        </el-form-item>

        <el-form-item label="单价" prop="drugsPrice">
          <el-input v-model="currentRow.drugsPrice"></el-input>
        </el-form-item>

        <el-form-item label="厂家" prop="manufacturer">
          <el-input v-model="currentRow.manufacturer"></el-input>
        </el-form-item>

        <el-form-item label="创建日期" prop="creationDate">
          <el-input v-model="currentRow.creationDate"></el-input>
        </el-form-item>

        <el-form-item label="修改日期" prop="lastUpdateDate">
          <el-input v-model="currentRow.lastUpdateDate"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="updateDialogVisable = false">取 消</el-button>
        <el-button type="primary" @click="doUpdate()">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
export default {
  data() {
    return {
      drugsList: [],
      total: 0,
      addDialogVisable: false,
      updateDialogVisable: false,
      addForm: {
        drugsCode: '',
        drugsTypeID: '',
        drugsName: '',
        drugsUnit: '',
        drugsFormat: '',
        manufacturer: '',
        drugsDosageID: '',
        drugsPrice: '',
        creationDate: '',
        mnemonicCode: '',
        lastUpdateDate: '',
        searchText: '',
      },
      currentRow: {
        drugsCode: '',
        drugsTypeID: '',
        drugsName: '',
        drugsUnit: '',
        drugsFormat: '',
        manufacturer: '',
        drugsDosageID: '',
        drugsPrice: '',
        creationDate: '',
        mnemonicCode: '',
        lastUpdateDate: '',
      },
    }
  },

  created() {
    this.doQuery()
  },

  mounted() {
    this.drugsList = this.$route.query.drugsList;
  },

  methods: {

    doQuery() {
      // console.log("this.$request",this.$request);
      let url = '/outpatientPharmacyWorkstation/drugCatalogueManagement/selectAll';
      console.log(this.addForm);
      this.$request({
        url,
        headers: {
          isToken: true
        },
        method: 'get',
        params: this.addForm
      }).then((resp) => {
        this.drugsList = resp.data.filter(item => item.delMark == 1);

      })
    },

    addDialogClosed() {
      this.$refs.addFormRed.resetFields()
    },

    updateDialogClosed() {
      this.$refs.addFormRed.resetFields()
    },
    changeTime(timestamp) {
      let date = new Date(timestamp);    //时间戳为10位需*1000，时间戳为13位的话不需乘1000
      let Y = date.getFullYear() + '-';
      let M = ((date.getMonth() + 1) < 10 ? '0' + (date.getMonth() + 1) :
        (date.getMonth() + 1)) + '-';
      let D = (date.getDate() < 10 ? '0' + date.getDate() : date.getDate()) + ' ';
      let h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
      let m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
      let s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds()

      return Y + M + D + h + m + s;
    },

    //添加用户
    doAdd() {
      let url = '/outpatientPharmacyWorkstation/drugCatalogueManagement/add';
      this.addForm.creationDate = this.changeTime(new Date().valueOf())



      this.$request({
        url,
        headers: {
          isToken: true
        },
        method: 'post',
        params: this.addForm
      }).then((resp) => {
        let i = resp.code;
        if (i == 200) {
          this.drugsList = []
          this.doQuery()

        } else {
          this.msg = '增加失败，请处理'
        }

      })
      this.addDialogVisable = false
    },

    doUpdate() {
      let url = '/outpatientPharmacyWorkstation/drugCatalogueManagement/update';
      this.currentRow.lastUpdateDate = this.changeTime(new Date().valueOf())

      this.$request({
        url,
        headers: {
          isToken: true
        },
        method: 'post',
        params: this.currentRow
      }).then((resp) => {
        let i = resp.code;
        if (i == 200) {
          this.drugsList = []
          this.doQuery()
        } else {
          this.msg = '修改失败，请处理'
        }
      })
      this.updateDialogVisable = false
    },

    enableUpdateDialog(param) {
      this.updateDialogVisable = true
      this.currentRow = param
    },
    doDelete(item) {
      let url = '/outpatientPharmacyWorkstation/drugCatalogueManagement/delete';
      this.$request({
        url,
        headers: {
          isToken: true
        },
        method: 'post',
        params: {
          id: item.id
        }
      }).then((resp) => {
        let i = resp.code;
        if (i == 200) {
          this.drugsList = []
          this.doQuery()
        } else {
          this.msg = '修改失败，请处理'
        }
      })
    }

  }
}
</script>

<style scoped></style>
