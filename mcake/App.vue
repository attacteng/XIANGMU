<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
			// 尝试提取本地存储用户信息
			try {
			    const value = uni.getStorageSync('userInfo');
			    if (value) {
			        this.$store.commit('user/initInfo',value)
					this.$store.dispatch('address/addressInitAct',value.objectId)
			    }
			} catch (e) {
			    // error
				console.log('提取用户信息失败',e);
			}
			// 设置默认勾选地址
			this.$store.commit('address/initCheckIdxMut')
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style lang="scss">
	/*每个页面公共css */
	@import "uview-ui/index.scss";
</style>
