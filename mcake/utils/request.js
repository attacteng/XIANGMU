let baseURL = 'https://api2105.h5project.cn'
export const $http = function (url,method='GET',data={}){
	return new Promise((resolve,reject)=>{
		uni.request({
			url:baseURL+url,
			method,
			header:{
				"X-LC-Id": "7yoqQxyLBNN9MW5rsgTGXbHL-gzGzoHsz",
				"X-LC-Key": "hA8yGYuHjnXWRui1rzTe0C3P",
				"Content-Type": "application/json"
			},
			data,
			success: (res) => {
				resolve(res.data)
			},
			fail: (err) => {
				reject(err)
			}
		})
	})
}

export const $get = function(url,data={}){
	return $http(url,'GET',data)
}

export const $post = function(url,data={}){
	return $http(url,'POST',data)
}

export const $put = function(url,data={}){
	return $http(url,'PUT',data)
}

export const $delete = function(url,data={}){
	return $http(url,'DELETE',data)
}
