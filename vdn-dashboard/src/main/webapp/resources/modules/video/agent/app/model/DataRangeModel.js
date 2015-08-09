Ext.define('ifeng.model.DataRangeModel', {
    extend: 'Ext.data.Model',
    alias: 'model.dataRageModel',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
            name: 'name',
            type: 'string'
        },
        {
            name: 'value',
            type: 'int'
        }
    ]
});