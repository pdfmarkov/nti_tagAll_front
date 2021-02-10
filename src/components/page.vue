<template>
 <div>
   <upper/>
   <info/>
   <div class="part1">
     <sending/>
     <about/>
   </div>


 </div>
</template>

<script>
import upper from '@/components/temp_main/upper'
import info from '@/components/temp_main/info'
import about from '@/components/temp_main/about'
import sending from '@/components/temp_main/sending'



export default {
  name: 'page',
  props: [],
  components: {
    upper,
    info,
    about,
    sending,

  },
}
</script>

<style>

</style>