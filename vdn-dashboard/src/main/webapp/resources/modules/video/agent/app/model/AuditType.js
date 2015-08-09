Ext.define('ifeng.model.AuditType', {
    extend: 'Ext.data.Model',
    alias: 'model.auditType',

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