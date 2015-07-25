Ext.define('ifeng.model.AvlbDaily', {
    extend: 'Ext.data.Model',
    alias: 'model.avlbDaily',

    requires: [
        'Ext.data.Field',
        'Ext.data.reader.Json'
    ],

    fields: [
        {
            name: 'err',
            type: 'string'
        },
        {
            name: 'total',
            type: 'int'
        },
        {
            name: 'ct',
            /*sortType: 'asDate',*/
            type: 'string'
        },
        {
            name: 'denominator',
            type: 'int'
        },
        {
            name: 'numerator',
            type: 'int'
        },
        {
            name: 'avlb',
            type: 'float'
        }
    ]
});