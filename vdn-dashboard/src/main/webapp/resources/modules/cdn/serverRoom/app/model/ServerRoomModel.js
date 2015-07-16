/**
 * 
 */
Ext.define('ifeng.model.ServerRoomModel', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
	    'id',
		'room_name',
		'room_code',
		'room_status',
		'data_status',
		'latest_time',
		'create_time'
	]
	
});