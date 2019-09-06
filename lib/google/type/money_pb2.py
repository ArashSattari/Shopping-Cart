# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: google/type/money.proto

from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
from google.protobuf import descriptor_pb2
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='google/type/money.proto',
  package='google.type',
  syntax='proto3',
  serialized_pb=b'\n\x17google/type/money.proto\x12\x0bgoogle.type\"<\n\x05Money\x12\x15\n\rcurrency_code\x18\x01 \x01(\t\x12\r\n\x05units\x18\x02 \x01(\x03\x12\r\n\x05nanos\x18\x03 \x01(\x05\x42\x1f\n\x0f\x63om.google.typeB\nMoneyProtoP\x01\x62\x06proto3'
)
_sym_db.RegisterFileDescriptor(DESCRIPTOR)




_MONEY = _descriptor.Descriptor(
  name='Money',
  full_name='google.type.Money',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='currency_code', full_name='google.type.Money.currency_code', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='units', full_name='google.type.Money.units', index=1,
      number=2, type=3, cpp_type=2, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='nanos', full_name='google.type.Money.nanos', index=2,
      number=3, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=40,
  serialized_end=100,
)

DESCRIPTOR.message_types_by_name['Money'] = _MONEY

Money = _reflection.GeneratedProtocolMessageType('Money', (_message.Message,), dict(
  DESCRIPTOR = _MONEY,
  __module__ = 'google.type.money_pb2'
  # @@protoc_insertion_point(class_scope:google.type.Money)
  ))
_sym_db.RegisterMessage(Money)


DESCRIPTOR.has_options = True
DESCRIPTOR._options = _descriptor._ParseOptions(descriptor_pb2.FileOptions(), b'\n\017com.google.typeB\nMoneyProtoP\001')
# @@protoc_insertion_point(module_scope)