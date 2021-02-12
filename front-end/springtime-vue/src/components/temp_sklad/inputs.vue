<template>
    <div>
        <div style="margin-left: 300px; margin-top: 50px; position:center">


            <table>
                <td> <tr>
                    <button class="input_11 b">Рассчитать</button>
                </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Время на операцию" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Оптимальное Расположение" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Сгруппировать товары  на складе по типу" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Сгруппировать товары  на складе по отгрузке" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Занимемое место" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Свободное место" title="почта" size="5">
                    </tr></td>
                <td> <tr>
                    <button class="input_11 b">Открыть базу данных склада</button>
                </tr>
                    <tr>
                        <input class="input_11 b" type="text" placeholder="Сортировка" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Количество" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Тип" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Расположение" title="почта" size="5">
                    </tr>
                   </td>

            </table>
                <div>
                    <button style="background-color: #0dabf5; width: 250px; height: 55px;margin-bottom:100px; margin-top:30px;border-radius: 7px;outline: 0 none !important;color: white;font-family: 'Arial';font-size: 20px;margin-left: 360px;">Выгрузить отчет</button>
                </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "inputs"
    }
</script>

<style scoped>


    .input_11 { /*переделать*/
        outline: none;
        width: 300px; /*ширина инпута  497.08px */
        height: 30px; /*высота инпута*/
        background-color: #F6FBFF;
        color: #4F4F4F;
        border: 1px solid #4F4F4F;
        box-sizing: border-box;
        border-radius: 15px;
        padding-left: 10px;


        font-size: 14px; /*размер шрифта*/
        font-style: normal;
        font-weight: normal;
    }
    .input_11.b{ /*переделать*/
        outline: none;
        width: 300px; /*ширина инпута  497.08px */
        height: 70px; /*высота инпута*/
        background-color: #F6FBFF;
        color: #4F4F4F;
        border: 1px solid #4F4F4F;
        box-sizing: border-box;
        border-radius: 20px;
        padding-left: 10px;


        font-size: 20px; /*размер шрифта*/
        font-style: normal;
        font-weight: normal;
    }
    .input_11:hover{
        background-color: rgba(255,0,0,0.2);
    }
    .input_11.b:hover{
        background-color: rgba(0, 255, 0, 0.2);
    }
</style>