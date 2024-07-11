import request from '@/utils/request'

// 查询交费管理列表
export function listJiaofei(query) {
  return request({
    url: '/jiaofei/jiaofei/list',
    method: 'get',
    params: query
  })
}

// 查询交费管理详细
export function getJiaofei(id) {
  return request({
    url: '/jiaofei/jiaofei/' + id,
    method: 'get'
  })
}

// 新增交费管理
export function addJiaofei(data) {
  return request({
    url: '/jiaofei/jiaofei',
    method: 'post',
    data: data
  })
}

// 修改交费管理
export function updateJiaofei(data) {
  return request({
    url: '/jiaofei/jiaofei',
    method: 'put',
    data: data
  })
}

// 删除交费管理
export function delJiaofei(id) {
  return request({
    url: '/jiaofei/jiaofei/' + id,
    method: 'delete'
  })
}


// 设置状态
export function updateStatus(id,status) {
  const data = {
    id,
    status
  }
  return request({
    url: '/jiaofei/jiaofei/updateStatus',
    method: 'post',
    data: data
  })
}
