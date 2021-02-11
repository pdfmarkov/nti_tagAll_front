<template>
  <div class="lk">
    <upper/>
    <user/>
    <downer/>
  </div>
</template>

<script>
import user from "@/components/temp_lk/user";
import upper from "@/components/temp_main/upper";
import downer from "@/components/temp_main/downer";

export default {
  name: "lk",
  components: {
    user,
    upper,
    downer,
  },
}
</script>

<style scoped>

</style>