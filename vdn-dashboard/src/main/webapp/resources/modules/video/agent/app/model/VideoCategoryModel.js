Ext.define('ifeng.model.VideoCategoryModel', {
    extend: 'Ext.data.Model',
    alias: 'model.videoModel',

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
            type: 'string'
        }
    ]
});